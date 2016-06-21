package el.actor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import el.client.Colors;
import el.map.ElMap;

import static el.actor.Attributes.Attribute;
import static el.actor.Attributes.BaseAttributes;
import static el.actor.Attributes.CrossAttributes;
import static el.actor.Attributes.NexusAttributes;
import static el.actor.Attributes.SkillAttributes;

public class Actor extends BaseActor {
    public Attribute etherealPoints = new Attribute();
    public Attribute capacity = new Attribute();
    public Attribute food = new Attribute();
    public Attribute actionPoints = new Attribute();

    //attribute grouping
    public BaseAttributes base = new BaseAttributes();
    public NexusAttributes nexuses = new NexusAttributes();
    public SkillAttributes skills = new SkillAttributes();
    public CrossAttributes cross = new CrossAttributes();

    public Item[] inventory = new Item[44];

    public Storage storage = new Storage();
    public Trade trade = new Trade();

    public Statistics statistics = new Statistics();

    public boolean harvesting = false;

    public int researching; // Researching anything (book code)
    public int research_completed; // Amount of pages read if a book is being read
    public int research_total; // Total pages in a book, if the player is reading a book
    public int minutes;

    public int last_exp_gained;
    public Span last_inventory_item_text = new Span(Colors.GREY1, "");
    public String last_PM_from = "";

    public ElMap map;
    public String mapPath;

    public int moveToX = -1;
    public int moveToY = -1;

    public List<Text> texts = new ArrayList<Text>();
    public Map<Integer, BaseActor> actors = new ConcurrentHashMap<Integer, BaseActor>();

    public int activeChannel = 0;
    public ArrayList<Integer> channels = new  ArrayList<Integer>(3){{add(0);add(0);add(0);}}; ;
}
