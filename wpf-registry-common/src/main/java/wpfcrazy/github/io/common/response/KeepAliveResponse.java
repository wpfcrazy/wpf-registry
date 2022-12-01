package wpfcrazy.github.io.common.response;

import lombok.Data;

@Data
public class KeepAliveResponse extends Response {
    private final long time;
}
