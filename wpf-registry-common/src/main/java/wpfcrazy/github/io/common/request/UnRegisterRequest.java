package wpfcrazy.github.io.common.request;

import lombok.Data;
import wpfcrazy.github.io.common.response.Response;

@Data
public class UnRegisterRequest extends Request{
    private String serviceName;
    private String ip;
    private int port;

    @Override
    public Response execute() {
        return null;
    }
}
