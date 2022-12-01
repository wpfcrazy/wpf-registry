package wpfcrazy.github.io.common;

import lombok.Data;
import wpfcrazy.github.io.common.serializer.SerializerAlgorithm;

@Data
public class MessageHeader {
    private Byte version = 1;
    private int actionCode;
    private long businessId;
    private Byte serializerAlgorithm = SerializerAlgorithm.JSON;
}
