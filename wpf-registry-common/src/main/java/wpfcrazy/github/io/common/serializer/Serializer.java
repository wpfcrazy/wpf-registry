package wpfcrazy.github.io.common.serializer;

public interface Serializer {

    Byte getSerializerAlgorithm();

    byte[] serialize(Object object);

    <T> T deserialize(byte[] bytes,Class<T> clazz);
}
