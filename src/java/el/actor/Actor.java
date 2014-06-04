package el.actor;

import el.client.Colors;
import el.map.ElMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Actor extends BaseActor {
    public Attribute etherealPoints = new Attribute();
    public Attribute capacity = new Attribute();
    public Attribute food = new Attribute();
    public Attribute action_points = new Attribute();

    // Base attributes
    public Attribute phy = new Attribute();
    public Attribute coo = new Attribute();
    public Attribute rea = new Attribute();
    public Attribute wil = new Attribute();
    public Attribute ins = new Attribute();
    public Attribute vit = new Attribute();

    // Nexus attributes
    public Attribute human_nex = new Attribute();
    public Attribute animal_nex = new Attribute();
    public Attribute vegetal_nex = new Attribute();
    public Attribute inorganic_nex = new Attribute();
    public Attribute artificial_nex = new Attribute();
    public Attribute magic_nex = new Attribute();

    // Skill attributes
    public Attribute manufacturing_skill = new Attribute();
    public Attribute harvesting_skill = new Attribute();
    public Attribute alchemy_skill = new Attribute();
    public Attribute overall_skill = new Attribute();
    public Attribute attack_skill = new Attribute();
    public Attribute defense_skill = new Attribute();
    public Attribute magic_skill = new Attribute();
    public Attribute potion_skill = new Attribute();
    public Attribute summoning_skill = new Attribute();
    public Attribute crafting_skill = new Attribute();
    public Attribute engineering_skill = new Attribute();
    public Attribute tailoring_skill = new Attribute();
    public Attribute ranging_skill = new Attribute();

    // Cross attributes
    public Attribute might = new Attribute();
    public Attribute matter = new Attribute();
    public Attribute toughness = new Attribute();
    public Attribute charm = new Attribute();
    public Attribute reaction = new Attribute();
    public Attribute perception = new Attribute();
    public Attribute rationality = new Attribute();
    public Attribute dexterity = new Attribute();
    public Attribute ethereality = new Attribute();


    public Item[] inventory = new Item[44];

    public Storage storage = new Storage();
    public Trade trade = new Trade();

    public Statistics statistics = new Statistics();

    public boolean harvesting = false;

    public int researching; // Researching anything (book code)
    public int research_completed; // Amount of pages read if a book is being read
    public int research_total; // Total pages in a book, if the player is reading a book
    public int is_researching;
    public int minutes;

    public int last_exp_gained;
    public Span last_inventory_item_text = new Span(Colors.GREY1, "");

    public ElMap map;
    public String mapPath;

    public int moveToX = -1;
    public int moveToY = -1;

    public List<Text> texts = new ArrayList<>();
    public Map<Integer, BaseActor> actors = new ConcurrentHashMap<>();

}
