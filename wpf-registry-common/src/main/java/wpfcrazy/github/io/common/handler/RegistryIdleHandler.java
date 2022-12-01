package wpfcrazy.github.io.common.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class RegistryIdleHandler extends IdleStateHandler {
    private static final int READ_IDLE_TIME = 15;

    public RegistryIdleHandler() {
        super(READ_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        log.info("{} 秒内未读到数据，关闭连接",READ_IDLE_TIME);
        ctx.channel().close();
    }
}
