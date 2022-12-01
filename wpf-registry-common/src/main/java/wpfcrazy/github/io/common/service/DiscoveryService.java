package wpfcrazy.github.io.common.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import wpfcrazy.github.io.common.request.RegisterRequest;
import wpfcrazy.github.io.common.response.ServiceInstance;
import wpfcrazy.github.io.common.response.ServiceItem;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class DiscoveryService {
    private static final Map<String, Set<ServiceInstance>> map = new ConcurrentHashMap<>();

    public static boolean store(RegisterRequest request){
        Set<ServiceInstance> serviceInstances = map.get(request.getServiceName());

        if (serviceInstances == null || serviceInstances.size() == 0)
            serviceInstances = new HashSet<>();
        ServiceInstance serviceInstance = new ServiceInstance();
        serviceInstance.setIp(request.getIp());
        serviceInstance.setPort(request.getPort());
        if (!serviceInstances.contains(serviceInstance)){
            serviceInstances.add(serviceInstance);
            map.put(request.getServiceName(),serviceInstances);
        }
        return true;
    }

    public static List<ServiceItem> getServiceItems(String serviceName){
        List<ServiceItem> serviceItems = new ArrayList<>();
        if (StringUtils.isBlank(serviceName)){
            for (String s:map.keySet()){
                ServiceItem serviceItem = new ServiceItem();
                serviceItem.setServiceName(s);
                serviceItem.setServiceInstances(new ArrayList<>(map.get(s)));
                serviceItems.add(serviceItem);
            }
        }else {
            ServiceItem serviceItem = new ServiceItem();
            serviceItem.setServiceName(serviceName);
            serviceItem.setServiceInstances(new ArrayList<>(map.get(serviceName)));
            serviceItems.add(serviceItem);
        }

        return serviceItems;
    }

    public static void shutdownServer() {
        log.info("shutdown server...");
    }
}
