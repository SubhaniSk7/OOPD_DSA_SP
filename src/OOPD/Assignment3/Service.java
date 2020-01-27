package OOPD.Assignment3;

public class Service {

	private int serviceId;
	private String serviceName;

	public Service() {

		this.serviceId = 0;
		this.serviceName = "";
	}

	public Service(int serviceId, String serviceName) {

		this.serviceId = serviceId;
		this.serviceName = serviceName;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}
