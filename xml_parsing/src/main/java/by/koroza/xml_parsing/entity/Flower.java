package by.koroza.xml_parsing.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.xml_parsing.exception.CustomFlowerException;

public class Flower {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String STRING_ID = "ID: ";
	private static final String STRING_NAME = "Name: ";
	private static final String STRING_SOILS = "Soils for flower: ";
	private static final String STRING_REGION = "Region: ";
	private static final String STRING_CENTURY = "Century: ";
	private static final String STRING_STEM_COLOR = "Stem color: ";
	private static final String STRING_LEAF_COLOR = "Leaf color: ";
	private static final String STRING_AVERAGE_PLANT_SIZE = "Average plant size: ";
	private static final String STRING_GROWING_TIPS = "Growing tips: ";
	private static final String STRING_MULTIPLYING = "Multiplying: ";
	private static final String STRING_PLANTING_DATE_TIME = "Planting date: ";
	private static final String STRING_NEXT_LINE = "\n";
	private static final String ERROR_ENTER_DATE_TIME_INCORRECT = "You entered incorrectly date or time: ";
	private String id;
	private String name;
	private List<String> soils;
	private String regionOrigin;
	private int centuryOrigin;
	private String stemСolor;
	private String leafColor;
	private AveragePlantSize averagePlantSize;
	private GrowingTips growingTips;
	private List<String> multiplying;
	private LocalDateTime plantingDate;

	public Flower() {
	}

	public Flower(String id, String name, List<String> soils, String regionOrigin, int centuryOrigin, String stemСolor,
			String leafColor, AveragePlantSize averagePlantSize, GrowingTips growingTips, List<String> multiplying,
			String dateTime) {
		this.id = id;
		this.name = name;
		this.soils = soils;
		this.regionOrigin = regionOrigin;
		this.centuryOrigin = centuryOrigin;
		this.stemСolor = stemСolor;
		this.leafColor = leafColor;
		this.averagePlantSize = averagePlantSize;
		this.growingTips = growingTips;
		this.multiplying = multiplying;
		this.plantingDate = LocalDateTime.parse(dateTime);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSoils() {
		return soils;
	}

	public void setSoils(List<String> soils) {
		this.soils = soils;
	}

	public String getRegionOrigin() {
		return regionOrigin;
	}

	public void setRegionOrigin(String regionOrigin) {
		this.regionOrigin = regionOrigin;
	}

	public int getCenturyOrigin() {
		return centuryOrigin;
	}

	public void setCenturyOrigin(int centuryOrigin) {
		this.centuryOrigin = centuryOrigin;
	}

	public String getStemСolor() {
		return stemСolor;
	}

	public void setStemСolor(String stemСolor) {
		this.stemСolor = stemСolor;
	}

	public String getLeafColor() {
		return leafColor;
	}

	public void setLeafColor(String leafColor) {
		this.leafColor = leafColor;
	}

	public AveragePlantSize getAveragePlantSize() {
		return averagePlantSize;
	}

	public void setAveragePlantSize(AveragePlantSize averagePlantSize) {
		this.averagePlantSize = averagePlantSize;
	}

	public GrowingTips getGrowingTips() {
		return growingTips;
	}

	public void setGrowingTips(GrowingTips growingTips) {
		this.growingTips = growingTips;
	}

	public List<String> getMultiplying() {
		return multiplying;
	}

	public void setMultiplying(List<String> multiplying) {
		this.multiplying = multiplying;
	}

	public LocalDateTime getPlantingDate() {
		return plantingDate;
	}

	public void setPlantingDate(String plantingDate) throws CustomFlowerException {
		try {
			this.plantingDate = LocalDateTime.parse(plantingDate);
		} catch (DateTimeParseException e) {
			LOGGER.log(Level.ERROR, ERROR_ENTER_DATE_TIME_INCORRECT + plantingDate);
			throw new CustomFlowerException(ERROR_ENTER_DATE_TIME_INCORRECT + plantingDate);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + (this.id != null ? this.id.hashCode() : 1);
		result = result * prime + (this.name != null ? this.name.hashCode() : 1);
		result = result * prime + (this.soils != null ? this.soils.hashCode() : 1);
		result = result * prime + (this.regionOrigin != null ? this.regionOrigin.hashCode() : 1);
		result = result * prime + this.centuryOrigin;
		result = result * prime + (this.stemСolor != null ? this.stemСolor.hashCode() : 1);
		result = result * prime + (this.leafColor != null ? this.leafColor.hashCode() : 1);
		result = result * prime + (this.averagePlantSize != null ? this.averagePlantSize.hashCode() : 1);
		result = result * prime + (this.growingTips != null ? this.growingTips.hashCode() : 1);
		result = result * prime + (this.multiplying != null ? this.multiplying.hashCode() : 1);
		result = result * prime + (this.plantingDate != null ? this.plantingDate.hashCode() : 1);
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
		Flower flower = (Flower) object;
		if (this.id == null) {
			if (flower.id != null) {
				return false;
			}
		} else if (!this.id.equals(flower.id)) {
			return false;
		}
		if (this.name == null) {
			if (flower.name != null) {
				return false;
			}
		} else if (!this.name.equals(flower.name)) {
			return false;
		}
		if (this.soils == null) {
			if (flower.soils != null) {
				return false;
			}
		} else if (!this.soils.equals(flower.soils)) {
			return false;
		}
		if (this.regionOrigin == null) {
			if (flower.regionOrigin != null) {
				return false;
			}
		} else if (!this.regionOrigin.equals(flower.regionOrigin)) {
			return false;
		}
		if (this.centuryOrigin != flower.centuryOrigin) {
			return false;
		}
		if (this.stemСolor == null) {
			if (flower.stemСolor != null) {
				return false;
			}
		} else if (!this.stemСolor.equals(flower.stemСolor)) {
			return false;
		}
		if (this.leafColor == null) {
			if (flower.leafColor != null) {
				return false;
			}
		} else if (!this.leafColor.equals(flower.leafColor)) {
			return false;
		}
		if (this.averagePlantSize == null) {
			if (flower.averagePlantSize != null) {
				return false;
			}
		} else if (!this.averagePlantSize.equals(flower.averagePlantSize)) {
			return false;
		}
		if (this.growingTips == null) {
			if (flower.growingTips != null) {
				return false;
			}
		} else if (!this.growingTips.equals(flower.growingTips)) {
			return false;
		}
		if (this.multiplying == null) {
			if (flower.multiplying != null) {
				return false;
			}
		} else if (!this.multiplying.equals(flower.multiplying)) {
			return false;
		}
		if (this.plantingDate == null) {
			if (flower.plantingDate != null) {
				return false;
			}
		} else if (!this.plantingDate.equals(flower.plantingDate)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(STRING_ID).append(this.id).append(STRING_NEXT_LINE);
		builder.append(STRING_NAME).append(this.name).append(STRING_NEXT_LINE);
		builder.append(STRING_SOILS).append(this.soils).append(STRING_NEXT_LINE);
		builder.append(STRING_REGION).append(this.regionOrigin).append(STRING_NEXT_LINE);
		builder.append(STRING_CENTURY).append(this.centuryOrigin).append(STRING_NEXT_LINE);
		builder.append(STRING_STEM_COLOR).append(this.stemСolor).append(STRING_NEXT_LINE);
		builder.append(STRING_LEAF_COLOR).append(this.leafColor).append(STRING_NEXT_LINE);
		builder.append(STRING_AVERAGE_PLANT_SIZE).append(this.averagePlantSize.toString()).append(STRING_NEXT_LINE);
		builder.append(STRING_GROWING_TIPS).append(this.growingTips).append(STRING_NEXT_LINE);
		builder.append(STRING_MULTIPLYING).append(this.multiplying).append(STRING_NEXT_LINE);
		builder.append(STRING_PLANTING_DATE_TIME)
				.append(this.plantingDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
				.append(STRING_NEXT_LINE);
		return builder.toString();
	}

	public static class FlowerBuilder {
		private final Flower flower;

		public FlowerBuilder() {
			flower = new Flower();
		}

		public FlowerBuilder setId(String id) {
			flower.setId(id);
			return this;
		}

		public FlowerBuilder setName(String name) {
			flower.setName(name);
			return this;
		}

		public FlowerBuilder setSoils(List<String> soils) {
			flower.setSoils(soils);
			return this;
		}

		public FlowerBuilder setRegionOrigin(String regionOrigin) {
			flower.setRegionOrigin(regionOrigin);
			return this;
		}

		public FlowerBuilder setCenturyOrigin(int centuryOrigin) {
			flower.setCenturyOrigin(centuryOrigin);
			return this;
		}

		public FlowerBuilder setStemСolor(String stemСolor) {
			flower.setStemСolor(stemСolor);
			return this;
		}

		public FlowerBuilder setLeafColor(String leafColor) {
			flower.setLeafColor(leafColor);
			return this;
		}

		public FlowerBuilder setAveragePlantSize(AveragePlantSize averagePlantSize) {
			flower.setAveragePlantSize(averagePlantSize);
			return this;
		}

		public FlowerBuilder setGrowingTips(GrowingTips growingTips) {
			flower.setGrowingTips(growingTips);
			return this;
		}

		public FlowerBuilder setMultiplying(List<String> multiplying) {
			flower.setMultiplying(multiplying);
			return this;
		}

		public FlowerBuilder setPlantingDate(String plantingDate) throws CustomFlowerException {
			flower.setPlantingDate(plantingDate);
			return this;
		}

		public Flower build() {
			return flower;
		}
	}
}