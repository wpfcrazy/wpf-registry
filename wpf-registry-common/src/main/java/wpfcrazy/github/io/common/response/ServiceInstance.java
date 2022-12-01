package wpfcrazy.github.io.common.response;

import lombok.Data;

import java.util.Objects;

@Data
public class ServiceInstance {
    private String ip;
    private int port;
    //实例访问频率
    private int weight = 1;
    private boolean health = true;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceInstance that = (ServiceInstance) o;
        return port == that.port && ip.equals(that.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port);
    }
}
