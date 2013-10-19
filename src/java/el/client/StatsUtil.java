package el.client;

import el.actor.Actor;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

import static el.utils.ByteUtils.nex4;

public class StatsUtil {
    public static final int PHY_CUR            = 0;
    public static final int PHY_BASE           = 1;
    public static final int COO_CUR            = 2;
    public static final int COO_BASE           = 3;
    public static final int REAS_CUR           = 4;
    public static final int REAS_BASE          = 5;
    public static final int WILL_CUR           = 6;
    public static final int WILL_BASE          = 7;
    public static final int INST_CUR           = 8;
    public static final int INST_BASE          = 9;
    public static final int VIT_CUR            = 10;
    public static final int VIT_BASE           = 11;
    public static final int HUMAN_CUR          = 12;
    public static final int HUMAN_BASE         = 13;
    public static final int ANIMAL_CUR         = 14;
    public static final int ANIMAL_BASE        = 15;
    public static final int VEGETAL_CUR        = 16;
    public static final int VEGETAL_BASE       = 17;
    public static final int INORG_CUR          = 18;
    public static final int INORG_BASE         = 19;
    public static final int ARTIF_CUR          = 20;
    public static final int ARTIF_BASE         = 21;
    public static final int MAGIC_CUR          = 22;
    public static final int MAGIC_BASE         = 23;
    public static final int MAN_S_CUR          = 24;
    public static final int MAN_S_BASE         = 25;
    public static final int HARV_S_CUR         = 26;
    public static final int HARV_S_BASE        = 27;
    public static final int ALCH_S_CUR         = 28;
    public static final int ALCH_S_BASE        = 29;
    public static final int OVRL_S_CUR         = 30;
    public static final int OVRL_S_BASE        = 31;
    public static final int DEF_S_CUR          = 32;
    public static final int DEF_S_BASE         = 33;
    public static final int ATT_S_CUR          = 34;
    public static final int ATT_S_BASE         = 35;
    public static final int MAG_S_CUR          = 36;
    public static final int MAG_S_BASE         = 37;
    public static final int POT_S_CUR          = 38;
    public static final int POT_S_BASE         = 39;
    public static final int CARRY_WGHT_CUR     = 40;
    public static final int CARRY_WGHT_BASE    = 41;
    public static final int MAT_POINT_CUR      = 42;
    public static final int MAT_POINT_BASE     = 43;
    public static final int ETH_POINT_CUR      = 44;
    public static final int ETH_POINT_BASE     = 45;
    public static final int FOOD_LEV           = 46;
    public static final int RESEARCHING        = 47;
    public static final int MAG_RES            = 48;
    public static final int MAN_EXP            = 49;
    public static final int MAN_EXP_NEXT       = 50;
    public static final int HARV_EXP           = 51;
    public static final int HARV_EXP_NEXT      = 52;
    public static final int ALCH_EXP           = 53;
    public static final int ALCH_EXP_NEXT      = 54;
    public static final int OVRL_EXP           = 55;
    public static final int OVRL_EXP_NEXT      = 56;
    public static final int DEF_EXP            = 57;
    public static final int DEF_EXP_NEXT       = 58;
    public static final int ATT_EXP            = 59;
    public static final int ATT_EXP_NEXT       = 60;
    public static final int MAG_EXP            = 61;
    public static final int MAG_EXP_NEXT       = 62;
    public static final int POT_EXP            = 63;
    public static final int POT_EXP_NEXT       = 64;
    public static final int RESEARCH_COMPLETED = 65;
    public static final int RESEARCH_TOTAL     = 66;
    public static final int SUM_EXP            = 67;
    public static final int SUM_EXP_NEXT       = 68;
    public static final int SUM_S_CUR          = 69;
    public static final int SUM_S_BASE         = 70;
    public static final int CRA_EXP            = 71;
    public static final int CRA_EXP_NEXT       = 72;
    public static final int CRA_S_CUR          = 73;
    public static final int CRA_S_BASE         = 74;
    public static final int ENG_EXP            = 75;
    public static final int ENG_EXP_NEXT       = 76;
    public static final int ENG_S_CUR          = 77;
    public static final int ENG_S_BASE         = 78;
    public static final int RANG_EXP           = 79;
    public static final int RANG_EXP_NEXT      = 80;
    public static final int RANG_S_CUR         = 81;
    public static final int RANG_S_BASE        = 82;
    public static final int TAIL_EXP           = 83;
    public static final int TAIL_EXP_NEXT      = 84;
    public static final int TAIL_S_CUR         = 85;
    public static final int TAIL_S_BASE        = 86;
    public static final int ACTION_POINTS_CUR  = 87;
    public static final int ACTION_POINTS_BASE = 88;

    public static void putStats(Actor actor, byte[] data) {
        ShortBuffer stats = ByteBuffer.wrap(data, 3, data.length - 3).order(ByteOrder.nativeOrder()).asShortBuffer();

        actor.capacity.current = unsigned(stats.get(40));
        actor.capacity.base = unsigned(stats.get(41));
        actor.materialPoints.current = unsigned(stats.get(42));
        actor.materialPoints.base = unsigned(stats.get(43));
        actor.etherealPoints.current = unsigned(stats.get(44));
        actor.etherealPoints.base = unsigned(stats.get(45));
        actor.food.current = stats.get(46);
        actor.food.base = 100;//really?!!!
    }

    public static void putPartialStats(Actor actor, byte[] source) {
        for(int index = 3; source.length - index >= 5; index += 5) {
            putSingleStat(actor, unsigned(source[index]), nex4(source, index + 1));
        }
    }

    private static void putSingleStat(Actor actor, int stat, int value) {
        switch (stat) {
            case  PHY_CUR            : break;
            case  PHY_BASE           : break;
            case  COO_CUR            : break;
            case  COO_BASE           : break;
            case  REAS_CUR           : break;
            case  REAS_BASE          : break;
            case  WILL_CUR           : break;
            case  WILL_BASE          : break;
            case  INST_CUR           : break;
            case  INST_BASE          : break;
            case  VIT_CUR            : break;
            case  VIT_BASE           : break;
            case  HUMAN_CUR          : break;
            case  HUMAN_BASE         : break;
            case  ANIMAL_CUR         : break;
            case  ANIMAL_BASE        : break;
            case  VEGETAL_CUR        : break;
            case  VEGETAL_BASE       : break;
            case  INORG_CUR          : break;
            case  INORG_BASE         : break;
            case  ARTIF_CUR          : break;
            case  ARTIF_BASE         : break;
            case  MAGIC_CUR          : break;
            case  MAGIC_BASE         : break;
            case  MAN_S_CUR          : break;
            case  MAN_S_BASE         : break;
            case  HARV_S_CUR         : break;
            case  HARV_S_BASE        : break;
            case  ALCH_S_CUR         : break;
            case  ALCH_S_BASE        : break;
            case  OVRL_S_CUR         : break;
            case  OVRL_S_BASE        : break;
            case  DEF_S_CUR          : break;
            case  DEF_S_BASE         : break;
            case  ATT_S_CUR          : break;
            case  ATT_S_BASE         : break;
            case  MAG_S_CUR          : break;
            case  MAG_S_BASE         : break;
            case  POT_S_CUR          : break;
            case  POT_S_BASE         : break;
            case  CARRY_WGHT_CUR     : actor.capacity.current = value; break;
            case  CARRY_WGHT_BASE    : actor.capacity.base = value; break;
            case  MAT_POINT_CUR      : actor.materialPoints.current = value; break;
            case  MAT_POINT_BASE     : actor.materialPoints.base = value; break;
            case  ETH_POINT_CUR      : actor.etherealPoints.current = value; break;
            case  ETH_POINT_BASE     : actor.etherealPoints.base = value; break;
            case  FOOD_LEV           : actor.food.current = value; break;
            case  RESEARCHING        : break;
            case  MAG_RES            : break;
            case  MAN_EXP            : break;
            case  MAN_EXP_NEXT       : break;
            case  HARV_EXP           : break;
            case  HARV_EXP_NEXT      : break;
            case  ALCH_EXP           : break;
            case  ALCH_EXP_NEXT      : break;
            case  OVRL_EXP           : break;
            case  OVRL_EXP_NEXT      : break;
            case  DEF_EXP            : break;
            case  DEF_EXP_NEXT       : break;
            case  ATT_EXP            : break;
            case  ATT_EXP_NEXT       : break;
            case  MAG_EXP            : break;
            case  MAG_EXP_NEXT       : break;
            case  POT_EXP            : break;
            case  POT_EXP_NEXT       : break;
            case  RESEARCH_COMPLETED : break;
            case  RESEARCH_TOTAL     : break;
            case  SUM_EXP            : break;
            case  SUM_EXP_NEXT       : break;
            case  SUM_S_CUR          : break;
            case  SUM_S_BASE         : break;
            case  CRA_EXP            : break;
            case  CRA_EXP_NEXT       : break;
            case  CRA_S_CUR          : break;
            case  CRA_S_BASE         : break;
            case  ENG_EXP            : break;
            case  ENG_EXP_NEXT       : break;
            case  ENG_S_CUR          : break;
            case  ENG_S_BASE         : break;
            case  RANG_EXP           : break;
            case  RANG_EXP_NEXT      : break;
            case  RANG_S_CUR         : break;
            case  RANG_S_BASE        : break;
            case  TAIL_EXP           : break;
            case  TAIL_EXP_NEXT      : break;
            case  TAIL_S_CUR         : break;
            case  TAIL_S_BASE        : break;
            case  ACTION_POINTS_CUR  : break;
            case  ACTION_POINTS_BASE : break;
        }
    }

    private static int unsigned(short stat) {
        return stat & 0xffff;
    }
}
