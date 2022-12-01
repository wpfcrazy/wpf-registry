package wpfcrazy.github.io.common.serializer.impl;

import com.alibaba.fastjson2.JSON;
import wpfcrazy.github.io.common.serializer.Serializer;
import wpfcrazy.github.io.common.serializer.SerializerAlgorithm;

public class JSONSerializer implements Serializer {

    private JSONSerializer(){}

    private final static JSONSerializer INSTANCE = new JSONSerializer();

    public static Serializer getSerializer(){
        return INSTANCE;
    }

    @Override
    public Byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes,clazz);
    }
}
