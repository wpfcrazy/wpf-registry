package wpfcrazy.github.io.common.request;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import wpfcrazy.github.io.common.response.RegisterResponse;
import wpfcrazy.github.io.common.response.Response;

@Data
@Slf4j
public class RegisterRequest extends Request{
    private String serviceName;
    private String ip;
    private int port;

    @Override
    public Response execute() {
        if (StringUtils.isBlank(serviceName)){
            throw new IllegalArgumentException("the serviceName is empty.");
        }
        if (StringUtils.isBlank(ip)){
            throw new IllegalArgumentException("the ip is empty.");
        }
        if (port<=0){
            throw new IllegalArgumentException("the port is illegal");
        }

        return new RegisterResponse(serviceName);
    }
}
