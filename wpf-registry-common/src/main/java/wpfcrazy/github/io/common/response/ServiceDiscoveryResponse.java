package wpfcrazy.github.io.common.response;

import lombok.Data;

import java.util.List;

@Data
public class ServiceDiscoveryResponse extends Response{
    private List<ServiceItem> serviceItems;
}
