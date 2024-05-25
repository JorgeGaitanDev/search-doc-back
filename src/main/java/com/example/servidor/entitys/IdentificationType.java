package com.example.servidor.entitys;

public enum IdentificationType {
    C("CEDULA"),
    P("PASAPORTE");

    private final String name;

    IdentificationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static IdentificationType fromName(String name) {
        for (IdentificationType type : IdentificationType.values()) {
            if (type.getName().equalsIgnoreCase(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid name: " + name);
    }
}

