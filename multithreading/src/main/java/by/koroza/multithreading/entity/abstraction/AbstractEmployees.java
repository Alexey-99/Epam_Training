package by.koroza.multithreading.entity.abstraction;

public abstract class AbstractEmployees {
	private static final String STRING_NAME_WITHOUT_NAME = "without name";
	private String name;

	public AbstractEmployees() {
		this.name = STRING_NAME_WITHOUT_NAME;
	}

	public AbstractEmployees(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + (this.name != null ? this.name.hashCode() : 1);
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
		AbstractEmployees otherAbstractEmployees = (AbstractEmployees) object;
		if (this.name == null) {
			if (otherAbstractEmployees.name != null) {
				return false;
			}
		} else if (!this.name.equals(otherAbstractEmployees.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Name: ").append(this.name);
		return builder.toString();
	}
}