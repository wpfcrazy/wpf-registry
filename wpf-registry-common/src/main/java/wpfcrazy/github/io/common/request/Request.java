package wpfcrazy.github.io.common.request;

import wpfcrazy.github.io.common.MessageBody;
import wpfcrazy.github.io.common.response.Response;

public abstract class Request extends MessageBody {
    public abstract Response execute();
}
