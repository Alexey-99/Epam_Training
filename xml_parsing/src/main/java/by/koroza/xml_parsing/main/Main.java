/** Cоздать xml-файл, хранящий информацию об объектах определенной предметной области. 
 * Для валидации полученного xml-файла необходимо разработать соответствующую ему схему xsd. 
 * Выполнить парсинг xmlдокумента с использованием DOM, SAX, StAX парсеров.  
 * 
 * Требования  
 *  - использовать для атрибутов required (+) & optional (-) +/-
 *  - перечисления +
 *  - шаблоны (+) и предельные значения(+) 
 *  - использовать тип ID +
 *  - задание значений атрибутов по умолчанию +
 *  - расширение типов (имитация наследования) (-)
 *  - использовать дату-время. В Java использовать только пакет java.time + 
 *  - создать в xml-документе не менее 16 сущностей 
 *  - парсеры организовать с помощью шаблона Builder 
 *  - для записи логов использовать Log4J2 
 *  - код должен быть покрыт тестами 
 *  
 *   Оранжерея 
 *   Растения, содержащиеся в оранжерее: 
 *   Name – название растения. 
 *   Soil – почва для посадки, которая может быть следующих типов: подзолистая, грунтовая, дерново-подзолистая. 
 *   Origin – место происхождения растения. 
 *   Visual рarameters (должно быть несколько) – внешние параметры: цвет стебля, цвет листьев, средний размер растения. 
 *   Growing tips (должно быть несколько) – предпочитаемые условия произрастания: температура (в градусах), 
 * освещение (светолюбиво либо нет), полив (мл в неделю). 
 *   Multiplying – размножение: листьями, черенками либо семенами. 
 *   Корневой элемент назвать Flowers. 
 */

package by.koroza.xml_parsing.main;

import static by.koroza.xml_parsing.enums.FlowerName.AFRICAN_DAISIES;
import static by.koroza.xml_parsing.enums.FlowerName.ALSTROEMERIA;
import static by.koroza.xml_parsing.enums.FlowerName.AMORPHOPHALLUS_TITANIC;
import static by.koroza.xml_parsing.enums.FlowerName.AQUILEGIA_COLOMBIAN;
import static by.koroza.xml_parsing.enums.FlowerName.ROSE;
import static by.koroza.xml_parsing.enums.ID.F1;
import static by.koroza.xml_parsing.enums.ID.F2;
import static by.koroza.xml_parsing.enums.ID.F3;
import static by.koroza.xml_parsing.enums.ID.F4;
import static by.koroza.xml_parsing.enums.ID.F5;
import static by.koroza.xml_parsing.enums.Measure.CENTIMETERS;
import static by.koroza.xml_parsing.enums.Measure.DEGREES_CELSIUS;
import static by.koroza.xml_parsing.enums.Measure.MILILITERS_PER_WEEK;
import static by.koroza.xml_parsing.enums.Multiplying.CUTTINGS;
import static by.koroza.xml_parsing.enums.Multiplying.DIVISION_THE_BUSH;
import static by.koroza.xml_parsing.enums.Multiplying.DIVISION_TUBERS;
import static by.koroza.xml_parsing.enums.Multiplying.GRAFTING_FROM_BUDS_BUDDING;
import static by.koroza.xml_parsing.enums.Multiplying.LAYERING;
import static by.koroza.xml_parsing.enums.Multiplying.SEEDS;
import static by.koroza.xml_parsing.enums.Region.COLOMBIA;
import static by.koroza.xml_parsing.enums.Region.PERSIA;
import static by.koroza.xml_parsing.enums.Region.PERU;
import static by.koroza.xml_parsing.enums.Region.SOUTH_AFRICA;
import static by.koroza.xml_parsing.enums.Region.SUMATRA_ISLAND;
import static by.koroza.xml_parsing.enums.Soil.CLAY;
import static by.koroza.xml_parsing.enums.Soil.FERTILE_LOOSE;
import static by.koroza.xml_parsing.enums.Soil.GARDEN_SOIL_AND_SAND;
import static by.koroza.xml_parsing.enums.Soil.LIGHT;
import static by.koroza.xml_parsing.enums.Soil.LOAMY;
import static by.koroza.xml_parsing.enums.Soil.LOOSE_MOIST;
import static by.koroza.xml_parsing.enums.Soil.MEDIUM_LOAMY;
import static by.koroza.xml_parsing.enums.Soil.SANDY;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.xml.sax.SAXException;

import by.koroza.xml_parsing.entity.AveragePlantSize;
import by.koroza.xml_parsing.entity.Flower;
import by.koroza.xml_parsing.entity.Greenhouse;
import by.koroza.xml_parsing.entity.GrowingTips;
import by.koroza.xml_parsing.entity.Temperature;
import by.koroza.xml_parsing.entity.Watering;
import by.koroza.xml_parsing.exception.CustomFlowerException;
import by.koroza.xml_parsing.exception.CustomParseException;
import by.koroza.xml_parsing.exception.CustomXMLFileException;
import by.koroza.xml_parsing.parsing.ParserFactory;

public class Main {
	private static final String STRING_CORRECT_PATH_XML = "src/main/resources/xml_files/flowersSAX.xml";
	private static final String STRING_CORRECT_PATH_XSD = "src/main/resources/xml_files/flowers.xsd";

	public static void main(String[] args)
			throws CustomFlowerException, CustomParseException, CustomXMLFileException, SAXException {
		new ParserFactory().parseXML(1, STRING_CORRECT_PATH_XML, STRING_CORRECT_PATH_XSD);
	}

	public static Greenhouse createGreenhouse()
			throws CustomFlowerException, CustomParseException, CustomXMLFileException {
		Set<Flower> flowers = new HashSet<>();
		List<String> soils = new ArrayList<>();
		List<String> multiplyingMethod = new ArrayList<>();

		soils.add(LIGHT.getName());
		soils.add(LOAMY.getName());
		soils.add(MEDIUM_LOAMY.getName());
		multiplyingMethod.add(SEEDS.getName());
		multiplyingMethod.add(LAYERING.getName());
		multiplyingMethod.add(GRAFTING_FROM_BUDS_BUDDING.getName());
		multiplyingMethod.add(CUTTINGS.getName());
		flowers.add(new Flower.FlowerBuilder().setId(F1.getId()).setName(ROSE.getName()).setSoils(soils)
				.setRegionOrigin(PERSIA.getName()).setCenturyOrigin(19).setStemСolor("green").setLeafColor("green")
				.setAveragePlantSize(new AveragePlantSize(CENTIMETERS.getName(), 70))
				.setGrowingTips(new GrowingTips(new Temperature(DEGREES_CELSIUS.getName(), -5), true,
						new Watering(MILILITERS_PER_WEEK.getName(), 10)))
				.setMultiplying(multiplyingMethod).setPlantingDate("2015-03-06T10:23:05").build());

		soils = new ArrayList<>();
		multiplyingMethod = new ArrayList<>();
		soils.add(CLAY.getName());
		soils.add(SANDY.getName());
		multiplyingMethod.add(SEEDS.getName());
		multiplyingMethod.add(GRAFTING_FROM_BUDS_BUDDING.getName());
		flowers.add(new Flower.FlowerBuilder().setId(F2.getId()).setName(ALSTROEMERIA.getName()).setSoils(soils)
				.setRegionOrigin(PERU.getName()).setCenturyOrigin(17).setStemСolor("green").setLeafColor("green")
				.setAveragePlantSize(new AveragePlantSize(CENTIMETERS.getName(), 150))
				.setGrowingTips(new GrowingTips(new Temperature(DEGREES_CELSIUS.getName(), +19), true,
						new Watering(MILILITERS_PER_WEEK.getName(), 5)))
				.setMultiplying(multiplyingMethod).setPlantingDate("2018-08-20T12:08:10").build());

		soils = new ArrayList<>();
		multiplyingMethod = new ArrayList<>();
		soils.add(LOOSE_MOIST.getName());
		multiplyingMethod.add(SEEDS.getName());
		multiplyingMethod.add(DIVISION_THE_BUSH.getName());
		flowers.add(new Flower.FlowerBuilder().setId(F3.getId()).setName(AQUILEGIA_COLOMBIAN.getName()).setSoils(soils)
				.setRegionOrigin(COLOMBIA.getName()).setCenturyOrigin(15).setStemСolor("green").setLeafColor("green")
				.setAveragePlantSize(new AveragePlantSize(CENTIMETERS.getName(), 100))
				.setGrowingTips(new GrowingTips(new Temperature(DEGREES_CELSIUS.getName(), +18), true,
						new Watering(MILILITERS_PER_WEEK.getName(), 6)))
				.setMultiplying(multiplyingMethod).setPlantingDate("2008-02-01T08:11:05").build());

		soils = new ArrayList<>();
		multiplyingMethod = new ArrayList<>();
		soils.add(GARDEN_SOIL_AND_SAND.getName());
		multiplyingMethod.add(DIVISION_TUBERS.getName());
		flowers.add(new Flower.FlowerBuilder().setId(F4.getId()).setName(AMORPHOPHALLUS_TITANIC.getName())
				.setSoils(soils).setRegionOrigin(SUMATRA_ISLAND.getName()).setCenturyOrigin(18).setStemСolor("green")
				.setLeafColor("green").setAveragePlantSize(new AveragePlantSize(CENTIMETERS.getName(), 300))
				.setGrowingTips(new GrowingTips(new Temperature(DEGREES_CELSIUS.getName(), +25), true,
						new Watering(MILILITERS_PER_WEEK.getName(), 20)))
				.setMultiplying(multiplyingMethod).setPlantingDate("2021-11-04T09:11:05").build());

		soils = new ArrayList<>();
		multiplyingMethod = new ArrayList<>();
		soils.add(FERTILE_LOOSE.getName());
		multiplyingMethod.add(SEEDS.getName());

		flowers.add(new Flower.FlowerBuilder().setId(F5.getId()).setName(AFRICAN_DAISIES.getName()).setSoils(soils)
				.setRegionOrigin(SOUTH_AFRICA.getName()).setCenturyOrigin(13).setStemСolor("green")
				.setLeafColor("green").setAveragePlantSize(new AveragePlantSize(CENTIMETERS.getName(), 23))
				.setGrowingTips(new GrowingTips(new Temperature(DEGREES_CELSIUS.getName(), +15), true,
						new Watering(MILILITERS_PER_WEEK.getName(), 15)))
				.setMultiplying(multiplyingMethod).setPlantingDate("2003-04-05T08:09:10").build());
		return new Greenhouse(flowers);
	}
}