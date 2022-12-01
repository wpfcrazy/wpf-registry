package wpfcrazy.github.io.common.response;

import lombok.Data;

import java.util.List;

@Data
public class ServiceItem {
    private String serviceName;
    /**
     * 当健康实例/总实例 < threshold时，触发保护模式，返回所有实例（健康+不健康）；
     * 否则返回健康实例
     */
    private float threshold;
    private List<ServiceInstance> serviceInstances;
}
