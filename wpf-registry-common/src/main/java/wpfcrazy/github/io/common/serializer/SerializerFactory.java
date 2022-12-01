package wpfcrazy.github.io.common.serializer;

import wpfcrazy.github.io.common.serializer.impl.JSONSerializer;

public class SerializerFactory {
    private SerializerFactory(){}

    public static Serializer getSerializerByAlgorithm(Byte algorithm){
        if (SerializerAlgorithm.JSON.equals(algorithm)){
            return JSONSerializer.getSerializer();
        }
        return JSONSerializer.getSerializer();
    }
}
