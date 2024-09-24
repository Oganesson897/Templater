package generator;

import com.example.example_mod.TestMetaItem;
import generator.annotations.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

public class ResourceGenerator {

    public static final Logger LOGGER = LogManager.getLogger("Generator");

    public static final String GEN_PATH = "src/generator/resources";

    public static final HashSet<StandardMetaItem> META_ITEM_CLASSES = new HashSet<>();

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        for (StandardMetaItem metaItem : META_ITEM_CLASSES) {
            metaItem.registerSubItems();
            if (metaItem.getClass().isAnnotationPresent(MetaItem.class)) {
                LOGGER.info(metaItem.getRegistryName());
                metaItem.getAllItems().forEach(item -> {
                    LOGGER.info(item.unlocalizedName);
                });
            }
        }
    }

    static {
        META_ITEM_CLASSES.add(new TestMetaItem());
    }

}
