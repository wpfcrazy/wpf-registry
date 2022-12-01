package wpfcrazy.github.io.common.request;

import lombok.Data;
import lombok.extern.java.Log;
import wpfcrazy.github.io.common.response.KeepAliveResponse;
import wpfcrazy.github.io.common.response.Response;

@Data
@Log
public class KeepAliveRequest extends Request{
    private long time;

    public KeepAliveRequest() {
        this.time = System.nanoTime();
    }

    @Override
    public Response execute() {
        return new KeepAliveResponse(time);
    }
}
