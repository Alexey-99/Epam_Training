package by.koroza.multithreading.entity.abstraction;

public abstract class AbstractEstablishment {
	private static long count = 1;
	private long id;

	public AbstractEstablishment() {
		this.id = count++;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + Long.hashCode(count);
		result = result * PRIME + Long.hashCode(this.id);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null) {
			return false;
		}
		if (!this.getClass().equals(object.getClass())) {
			return false;
		}
		AbstractEstablishment otherAbstractEstablishment = (AbstractEstablishment) object;
		if (this.id != otherAbstractEstablishment.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbstractEstablishment [id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
}