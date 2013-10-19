package el.actor;

import el.map.ElMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Actor extends BaseActor {
    public Attribute etherealPoints = new Attribute();
    public Attribute capacity = new Attribute();
    public Attribute food = new Attribute();
    public Item[] inventory = new Item[44];

    public Storage storage = new Storage();
    public Trade trade = new Trade();

    public Statistics statistics = new Statistics();

    public boolean harvesting = false;

    public int minutes;

    public ElMap map;
    public String mapPath;

    public int moveToX = -1;
    public int moveToY = -1;

    public List<Text> texts = new ArrayList<>();
    public Map<Integer, BaseActor> actors = new ConcurrentHashMap<>();
}
