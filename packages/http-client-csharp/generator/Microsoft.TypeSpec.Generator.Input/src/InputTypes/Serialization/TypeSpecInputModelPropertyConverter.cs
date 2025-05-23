// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

using System;
using System.Collections.Generic;
using System.Text.Json;
using System.Text.Json.Serialization;

namespace Microsoft.TypeSpec.Generator.Input
{
    internal sealed class TypeSpecInputModelPropertyConverter : JsonConverter<InputModelProperty>
    {
        private readonly TypeSpecReferenceHandler _referenceHandler;

        public TypeSpecInputModelPropertyConverter(TypeSpecReferenceHandler referenceHandler)
        {
            _referenceHandler = referenceHandler;
        }

        public override InputModelProperty Read(ref Utf8JsonReader reader, Type typeToConvert, JsonSerializerOptions options)
            => reader.ReadReferenceAndResolve<InputModelProperty>(_referenceHandler.CurrentResolver) ?? ReadInputModelProperty(ref reader, null, null, options, _referenceHandler.CurrentResolver);

        public override void Write(Utf8JsonWriter writer, InputModelProperty value, JsonSerializerOptions options)
            => throw new NotSupportedException("Writing not supported");

        private static InputModelProperty ReadInputModelProperty(ref Utf8JsonReader reader, string? id, string? name, JsonSerializerOptions options, ReferenceResolver resolver)
        {
            if (id == null)
            {
                reader.TryReadReferenceId(ref id);
            }

            id = id ?? throw new JsonException();

            // create an empty model property to resolve circular references
            var property = new InputModelProperty(
                name: null!,
                kind: default,
                summary: null,
                doc: null,
                type: null!,
                isRequired: false,
                isReadOnly: false,
                isDiscriminator: false,
                serializedName: null!,
                serializationOptions: null!);
            resolver.AddReference(id, property);

            var isFirstProperty = true;
            string? kind = null;
            string? summary = null;
            string? doc = null;
            string? serializedName = null;
            InputType? propertyType = null;
            bool isReadOnly = false;
            bool isOptional = false;
            bool isDiscriminator = false;
            IReadOnlyList<InputDecoratorInfo>? decorators = null;
            InputSerializationOptions? serializationOptions = null;

            while (reader.TokenType != JsonTokenType.EndObject)
            {
                var isKnownProperty = reader.TryReadReferenceId(ref isFirstProperty, ref id)
                    || reader.TryReadString("name", ref name)
                    || reader.TryReadString("kind", ref kind)
                    || reader.TryReadString("summary", ref summary)
                    || reader.TryReadString("doc", ref doc)
                    || reader.TryReadComplexType("type", options, ref propertyType)
                    || reader.TryReadBoolean("readOnly", ref isReadOnly)
                    || reader.TryReadBoolean("optional", ref isOptional)
                    || reader.TryReadBoolean("discriminator", ref isDiscriminator)
                    || reader.TryReadComplexType("decorators", options, ref decorators)
                    || reader.TryReadString("serializedName", ref serializedName)
                    || reader.TryReadComplexType("serializationOptions", options, ref serializationOptions);

                if (!isKnownProperty)
                {
                    reader.SkipProperty();
                }
            }

            if (kind == null)
            {
                throw new JsonException("Property must have kind");
            }
            Enum.TryParse(kind, ignoreCase: true, out InputModelPropertyKind propertyKind);

            property.Name = name ?? throw new JsonException($"{nameof(InputModelProperty)} must have a name.");
            property.Kind = propertyKind;
            property.Summary = summary;
            property.Doc = doc;
            property.Type = propertyType ?? throw new JsonException($"{nameof(InputModelProperty)} must have a property type.");
            property.IsRequired = !isOptional;
            property.IsReadOnly = isReadOnly;
            property.IsDiscriminator = isDiscriminator;
            property.Decorators = decorators ?? [];
            property.SerializationOptions = serializationOptions;
            property.DefaultSerializedName = serializedName;

            return property;
        }
    }
}
