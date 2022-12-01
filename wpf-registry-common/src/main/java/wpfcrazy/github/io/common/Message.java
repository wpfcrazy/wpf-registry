package wpfcrazy.github.io.common;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import wpfcrazy.github.io.common.serializer.Serializer;
import wpfcrazy.github.io.common.serializer.SerializerFactory;

@Data
public abstract class Message<T extends MessageBody> {
    public static final int MAGIC_NUMBER = 0x12346587;

    private MessageHeader messageHeader;

    private T messageBody;

    public void encode(ByteBuf byteBuf){
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(messageHeader.getVersion());
        byteBuf.writeInt(messageHeader.getActionCode());
        byteBuf.writeLong(messageHeader.getBusinessId());
        byteBuf.writeByte(messageHeader.getSerializerAlgorithm());

        Serializer serializer = SerializerFactory.getSerializerByAlgorithm(messageHeader.getSerializerAlgorithm());
        byte[] bytes = serializer.serialize(messageBody);
        byteBuf.writeInt(bytes.length);

        byteBuf.writeBytes(bytes);
    }

    public void decode(ByteBuf byteBuf){
        byteBuf.skipBytes(4);
        MessageHeader messageHeader1 = new MessageHeader();
        messageHeader1.setVersion(byteBuf.readByte());
        messageHeader1.setActionCode(byteBuf.readInt());
        messageHeader1.setBusinessId(byteBuf.readLong());
        messageHeader1.setSerializerAlgorithm(byteBuf.readByte());

        this.messageHeader = messageHeader1;

        int length = byteBuf.readInt();
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);

        Serializer serializer = SerializerFactory.getSerializerByAlgorithm(messageHeader.getSerializerAlgorithm());
        Class<T> clazz = getMessageBodyByActionCode(messageHeader.getActionCode());
        messageBody = serializer.deserialize(bytes,clazz);
    }

    public abstract Class<T> getMessageBodyByActionCode(int actionCode);
}
