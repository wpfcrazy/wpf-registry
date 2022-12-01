package wpfcrazy.github.io.common.request;

import lombok.Data;
import wpfcrazy.github.io.common.response.Response;
import wpfcrazy.github.io.common.response.ServiceDiscoveryResponse;
import wpfcrazy.github.io.common.service.DiscoveryService;

@Data
public class ServiceDiscoveryRequest extends Request{
    private String serviceName;

    @Override
    public Response execute() {
        ServiceDiscoveryResponse serviceDiscoveryResponse = new ServiceDiscoveryResponse();
        serviceDiscoveryResponse.setServiceItems(DiscoveryService.getServiceItems(serviceName));
        return serviceDiscoveryResponse;
    }
}
