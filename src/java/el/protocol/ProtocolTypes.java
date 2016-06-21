package el.protocol;

// Extra info at http://wiki.alexcollins.org/index.php/Eternal_Lands_Network_Protocol

public class ProtocolTypes {
    //common
    public static final byte RAW_TEXT = 0;

    //client to server
    public static final int MOVE_TO = 1;
    public static final int SEND_PM = 2;
    public static final int GET_PLAYER_INFO = 5; // Used when eye-clicking an actor.
    public static final int SIT_DOWN = 7;
    public static final int SEND_OPENING_SCREEN = 9;
    public static final int SEND_VERSION = 10;
    public static final int TURN_LEFT = 11;
    public static final int TURN_RIGHT = 12;
    public static final int PING = 13; // TODO add ping command
    public static final int HEART_BEAT = 14;
    public static final int LOCATE_ME = 15;  //TODO add locate me command
    public static final int USE_MAP_OBJECT = 16;
    public static final int LOOK_AT_INVENTORY_ITEM = 19; //TODO Used when eye-clicking an item.
    public static final int MOVE_INVENTORY_ITEM = 20;
    public static final int HARVEST = 21;
    public static final int DROP_ITEM = 22; //TODO drop/pickup Server just drops to the actual quantity the slot holds if you attempt to drop more than the inventory amount.
    public static final int PICK_UP_ITEM = 23;
    public static final int LOOK_AT_GROUND_ITEM = 24;
    public static final int INSPECT_BAG = 25;
    public static final int S_CLOSE_BAG = 26;
    public static final int TOUCH_PLAYER = 28;
    public static final int RESPOND_TO_NPC = 29;
    public static final int MANUFACTURE_THIS = 30;
    public static final int USE_INVENTORY_ITEM = 31;
    public static final int TRADE_WITH = 32;
    public static final int ACCEPT_TRADE = 33;
    public static final int REJECT_TRADE = 34;
    public static final int EXIT_TRADE = 35;
    public static final int PUT_OBJECT_ON_TRADE = 36;
    public static final int REMOVE_OBJECT_FROM_TRADE = 37;
    public static final int GET_STORAGE_CATEGORY = 44;
    public static final int DEPOSITE_ITEM = 45;
    public static final int WITHDRAW_ITEM = 46;
    public static final int LOG_IN = 140;

    //server to client
    public static final int ADD_NEW_ACTOR = 1;
    public static final int ADD_ACTOR_COMMAND = 2;
    public static final int YOU_ARE = 3;
    public static final int NEW_MINUTE = 5;
    public static final int REMOVE_ACTOR = 6;
    public static final int CHANGE_MAP = 7;
    public static final int KILL_ALL_ACTORS = 9;
    public static final int HERE_YOUR_STATS = 18;
    public static final int HERE_YOUR_INVENTORY = 19;
    public static final int INVENTORY_ITEM_TEXT = 20; // sent when manufacture happens?
    public static final int GET_NEW_INVENTORY_ITEM = 21;
    public static final int REMOVE_ITEM_FROM_INVENTORY = 22;
    public static final int NPC_OPTIONS_LIST = 31;
    public static final int GET_TRADE_OBJECT = 35;
    public static final int GET_TRADE_ACCEPT = 36;
    public static final int GET_TRADE_REJECT = 37;
    public static final int GET_TRADE_EXIT = 38;
    public static final int REMOVE_TRADE_OBJECT = 39;
    public static final int GET_YOUR_TRADEOBJECTS = 40;
    public static final int GET_TRADE_PARTNER_NAME = 41;
    public static final int GET_YOUR_SIGILS = 42; //TODO magic source 2a0500ffcffb01
    public static final int GET_ACTIVE_SPELL_LIST = 45; //TODO magic 2d0b00ffffffffffffffffffff
    public static final int GET_ACTOR_HEAL = 48; //TODO example source 300500f3000100
    public static final int SEND_PARTIAL_STAT = 49;
    public static final int ADD_NEW_ENHANCED_ACTOR = 51; //example 332f00f30026009a0000003b0129000208380804020b0e03140ef000db00015a616d69726168208f414c47000040ff0005 332e003b003300970000002d0002000400000006030b0e031407910091000144656d616420894c6f7453000040ff000c
    public static final int GET_KNOWLEDGE_LIST = 55; //TODO knowledge 373300fffdfff327fdffffff29f7fffff3e77b0600000000000000007001030000000080fd0000d019001000880100000000000000
    public static final int PING_REQUEST = 60;
    public static final int STORAGE_LIST = 67;
    public static final int STORAGE_ITEMS = 68;
    public static final int GET_ACTIVE_CHANNELS = 71; //TODO active channels 4712000303000000620000002102000022020000
    public static final int GET_ITEMS_COOLDOWN = 77;
    public static final int YOU_DONT_EXIST = 249;
    public static final int LOG_IN_OK = 250;
    public static final int LOG_IN_NOT_OK = 251;
}
