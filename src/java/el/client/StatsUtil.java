package el.client;

import el.actor.Actor;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

import static el.utils.ByteUtils.nex4;

public class StatsUtil {
    // My IDE suggests all these variables could be private. Any advantage, or use of public or private?
    public static final int PHY_CUR = 0;
    public static final int PHY_BASE = 1;
    public static final int COO_CUR = 2;
    public static final int COO_BASE = 3;
    public static final int REAS_CUR = 4;
    public static final int REAS_BASE = 5;
    public static final int WILL_CUR = 6;
    public static final int WILL_BASE = 7;
    public static final int INST_CUR = 8;
    public static final int INST_BASE = 9;
    public static final int VIT_CUR = 10;
    public static final int VIT_BASE = 11;
    public static final int HUMAN_CUR = 12;
    public static final int HUMAN_BASE = 13;
    public static final int ANIMAL_CUR = 14;
    public static final int ANIMAL_BASE = 15;
    public static final int VEGETAL_CUR = 16;
    public static final int VEGETAL_BASE = 17;
    public static final int INORG_CUR = 18;
    public static final int INORG_BASE = 19;
    public static final int ARTIF_CUR = 20;
    public static final int ARTIF_BASE = 21;
    public static final int MAGIC_CUR = 22;
    public static final int MAGIC_BASE = 23;
    public static final int MAN_S_CUR = 24;
    public static final int MAN_S_BASE = 25;
    public static final int HARV_S_CUR = 26;
    public static final int HARV_S_BASE = 27;
    public static final int ALCH_S_CUR = 28;
    public static final int ALCH_S_BASE = 29;
    public static final int OVRL_S_CUR = 30;
    public static final int OVRL_S_BASE = 31;
    public static final int DEF_S_CUR = 32;
    public static final int DEF_S_BASE = 33;
    public static final int ATT_S_CUR = 34;
    public static final int ATT_S_BASE = 35;
    public static final int MAG_S_CUR = 36;
    public static final int MAG_S_BASE = 37;
    public static final int POT_S_CUR = 38;
    public static final int POT_S_BASE = 39;
    public static final int CARRY_WGHT_CUR = 40;
    public static final int CARRY_WGHT_BASE = 41;
    public static final int MAT_POINT_CUR = 42;
    public static final int MAT_POINT_BASE = 43;
    public static final int ETH_POINT_CUR = 44;
    public static final int ETH_POINT_BASE = 45;
    public static final int FOOD_LEV = 46;
    public static final int RESEARCHING = 47;
    public static final int MAG_RES = 48;
    public static final int MAN_EXP = 49;
    public static final int MAN_EXP_NEXT = 50;
    public static final int HARV_EXP = 51;
    public static final int HARV_EXP_NEXT = 52;
    public static final int ALCH_EXP = 53;
    public static final int ALCH_EXP_NEXT = 54;
    public static final int OVRL_EXP = 55;
    public static final int OVRL_EXP_NEXT = 56;
    public static final int DEF_EXP = 57;
    public static final int DEF_EXP_NEXT = 58;
    public static final int ATT_EXP = 59;
    public static final int ATT_EXP_NEXT = 60;
    public static final int MAG_EXP = 61;
    public static final int MAG_EXP_NEXT = 62;
    public static final int POT_EXP = 63;
    public static final int POT_EXP_NEXT = 64;
    public static final int RESEARCH_COMPLETED = 65;
    public static final int RESEARCH_TOTAL = 66;
    public static final int SUM_EXP = 67;
    public static final int SUM_EXP_NEXT = 68;
    public static final int SUM_S_CUR = 69;
    public static final int SUM_S_BASE = 70;
    public static final int CRA_EXP = 71;
    public static final int CRA_EXP_NEXT = 72;
    public static final int CRA_S_CUR = 73;
    public static final int CRA_S_BASE = 74;
    public static final int ENG_EXP = 75;
    public static final int ENG_EXP_NEXT = 76;
    public static final int ENG_S_CUR = 77;
    public static final int ENG_S_BASE = 78;
    public static final int RANG_EXP = 79;
    public static final int RANG_EXP_NEXT = 80;
    public static final int RANG_S_CUR = 81;
    public static final int RANG_S_BASE = 82;
    public static final int TAIL_EXP = 83;
    public static final int TAIL_EXP_NEXT = 84;
    public static final int TAIL_S_CUR = 85;
    public static final int TAIL_S_BASE = 86;
    public static final int ACTION_POINTS_CUR = 87;
    public static final int ACTION_POINTS_BASE = 88;


    public static void putStats(Actor actor, byte[] data) {
        // Initial message and update message order codes are different!
        // Overall current is 55 for partial send message, but it is 61-62 in short buffer.
        // Needs defining all the parameters for initializations.
        // The above codes are for partial messages, this is how it is implemented in original client.
        // The first initialization should be done as in "get_the_stats" function in stats.c
        ShortBuffer stats = ByteBuffer.wrap(data, 3, data.length - 3).order(ByteOrder.nativeOrder()).asShortBuffer();

        // Actor single attributes
        actor.capacity.current = unsigned(stats.get(40));
        actor.capacity.base = unsigned(stats.get(41));
        actor.materialPoints.current = unsigned(stats.get(42));
        actor.materialPoints.base = unsigned(stats.get(43));
        actor.etherealPoints.current = unsigned(stats.get(44));
        actor.etherealPoints.base = unsigned(stats.get(45));
        actor.food.current = stats.get(46);
        actor.food.base = 100;//really?!!!
        actor.research_completed = unsigned(stats.get(47));
        actor.researching = unsigned(stats.get(81));
        actor.research_total = unsigned(stats.get(82));

        // Fill Base attributes
        actor.phy.current = unsigned(stats.get(0));
        actor.phy.base = unsigned(stats.get(1));
        actor.coo.current = unsigned(stats.get(2));
        actor.coo.base = unsigned(stats.get(3));
        actor.rea.current = unsigned(stats.get(4));
        actor.rea.base = unsigned(stats.get(5));
        actor.wil.current = unsigned(stats.get(6));
        actor.wil.base = unsigned(stats.get(7));
        actor.ins.current = unsigned(stats.get(8));
        actor.ins.base = unsigned(stats.get(9));
        actor.vit.current = unsigned(stats.get(10));
        actor.vit.base = unsigned(stats.get(11));

        // Fill Nexus attributes
        actor.human_nex.current = unsigned(stats.get(12));
        actor.human_nex.base = unsigned(stats.get(13));
        actor.animal_nex.current = unsigned(stats.get(14));
        actor.animal_nex.base = unsigned(stats.get(15));
        actor.vegetal_nex.current = unsigned(stats.get(16));
        actor.vegetal_nex.base = unsigned(stats.get(17));
        actor.inorganic_nex.current = unsigned(stats.get(18));
        actor.inorganic_nex.base = unsigned(stats.get(19));
        actor.artificial_nex.current = unsigned(stats.get(20));
        actor.artificial_nex.base = unsigned(stats.get(21));
        actor.magic_nex.current = unsigned(stats.get(22));
        actor.magic_nex.base = unsigned(stats.get(23));

        // Fill skill attributes
        actor.manufacturing_skill.current = unsigned(stats.get(24));
        actor.manufacturing_skill.base = unsigned(stats.get(25));
        actor.harvesting_skill.current = unsigned(stats.get(26));
        actor.harvesting_skill.base = unsigned(stats.get(27));
        actor.alchemy_skill.current = unsigned(stats.get(28));
        actor.alchemy_skill.base = unsigned(stats.get(29));
        actor.overall_skill.current = unsigned(stats.get(30));
        actor.overall_skill.base = unsigned(stats.get(31));
        actor.attack_skill.current = unsigned(stats.get(32));
        actor.attack_skill.base = unsigned(stats.get(33));
        actor.defense_skill.current = unsigned(stats.get(34));
        actor.defense_skill.base = unsigned(stats.get(35));
        actor.magic_skill.current = unsigned(stats.get(36));
        actor.magic_skill.base = unsigned(stats.get(37));
        actor.potion_skill.current = unsigned(stats.get(38));
        actor.potion_skill.base = unsigned(stats.get(39));
        actor.summoning_skill.current = unsigned(stats.get(83));
        actor.summoning_skill.base = unsigned(stats.get(84));
        actor.crafting_skill.current = unsigned(stats.get(89));
        actor.crafting_skill.base = unsigned(stats.get(90));
        actor.engineering_skill.current = unsigned(stats.get(95));
        actor.engineering_skill.base = unsigned(stats.get(96));
        actor.tailoring_skill.current = unsigned(stats.get(101));
        actor.tailoring_skill.base = unsigned(stats.get(102));
        actor.ranging_skill.current = unsigned(stats.get(107));
        actor.ranging_skill.base = unsigned(stats.get(108));
        actor.action_points.current = unsigned(stats.get(113));
        actor.action_points.base = unsigned(stats.get(114));

        // Fill experience points
        actor.statistics.manufacturing_exp.current = nex_int(stats.get(49), stats.get(50));
        actor.statistics.manufacturing_exp.base = nex_int(stats.get(51), stats.get(52));
        actor.statistics.harvesting_exp.current = nex_int(stats.get(53), stats.get(54));
        actor.statistics.harvesting_exp.base = nex_int(stats.get(55), stats.get(56));
        actor.statistics.alchemy_exp.current = nex_int(stats.get(57), stats.get(58));
        actor.statistics.alchemy_exp.base = nex_int(stats.get(59), stats.get(60));
        actor.statistics.overall_exp.current = nex_int(stats.get(61), stats.get(62));
        actor.statistics.overall_exp.base = nex_int(stats.get(63), stats.get(64));
        actor.statistics.attack_exp.current = nex_int(stats.get(65), stats.get(66));
        actor.statistics.attack_exp.base = nex_int(stats.get(67), stats.get(68));
        actor.statistics.defense_exp.current = nex_int(stats.get(69), stats.get(70));
        actor.statistics.defense_exp.base = nex_int(stats.get(71), stats.get(72));
        actor.statistics.magic_exp.current = nex_int(stats.get(73), stats.get(74));
        actor.statistics.magic_exp.base = nex_int(stats.get(75), stats.get(76));
        actor.statistics.potion_exp.current = nex_int(stats.get(77), stats.get(78));
        actor.statistics.potion_exp.base = nex_int(stats.get(79), stats.get(80));
        actor.statistics.summoning_exp.current = nex_int(stats.get(85), stats.get(86));
        actor.statistics.summoning_exp.base = nex_int(stats.get(87), stats.get(88));
        actor.statistics.crafting_exp.current = nex_int(stats.get(91), stats.get(92));
        actor.statistics.crafting_exp.base = nex_int(stats.get(93), stats.get(94));
        actor.statistics.engineering_exp.current = nex_int(stats.get(97), stats.get(98));
        actor.statistics.engineering_exp.base = nex_int(stats.get(99), stats.get(100));
        actor.statistics.tailoring_exp.current = nex_int(stats.get(103), stats.get(104));
        actor.statistics.tailoring_exp.base = nex_int(stats.get(105), stats.get(106));
        actor.statistics.ranging_exp.current = nex_int(stats.get(109), stats.get(110));
        actor.statistics.ranging_exp.base = nex_int(stats.get(111), stats.get(112));

        // Cross attributes, calculation (taken from stats.c)

        actor.might.base = (actor.phy.base + actor.coo.base) / 2;
        actor.might.current = (actor.phy.current + actor.coo.current) / 2;
        actor.matter.base = (actor.phy.base + actor.wil.base) / 2;
        actor.matter.current = (actor.phy.current + actor.wil.current) / 2;
        actor.toughness.base = (actor.phy.base + actor.vit.base) / 2;
        actor.toughness.current = (actor.phy.current + actor.vit.current) / 2;
        actor.charm.base = (actor.ins.base + actor.vit.base) / 2;
        actor.charm.current = (actor.ins.current + actor.vit.current) / 2;
        actor.reaction.base = (actor.ins.base + actor.coo.base) / 2;
        actor.reaction.current = (actor.ins.current + actor.coo.current) / 2;
        actor.perception.base = (actor.ins.base + actor.rea.base) / 2;
        actor.perception.current = (actor.ins.current + actor.rea.current) / 2;
        actor.rationality.base = (actor.wil.base + actor.rea.base) / 2;
        actor.rationality.current = (actor.wil.current + actor.rea.current) / 2;
        actor.dexterity.base = (actor.coo.base + actor.rea.base) / 2;
        actor.dexterity.current = (actor.coo.current + actor.rea.current) / 2;
        actor.ethereality.base = (actor.wil.base + actor.vit.base) / 2;
        actor.ethereality.current = (actor.wil.current + actor.vit.current) / 2;

    }


    public static void putPartialStats(Actor actor, byte[] source) {
        for (int index = 3; source.length - index >= 5; index += 5) {
            if (unsigned(source[index]) == 55) {
                // If there is a change in the overall experience coming through partial stats.
                // Get the difference between new experience value and the players current experience value
                // to get the last gained experience.
                // Used now as a popup experience information somewhere on screen (like in desktop client)
                actor.last_exp_gained = nex4(source, index + 1) - actor.statistics.overall_exp.current;
            }
            putSingleStat(actor, unsigned(source[index]), nex4(source, index + 1));

        }
    }

    private static void putSingleStat(Actor actor, int stat, int value) {
        switch (stat) {
            case PHY_CUR:
                actor.phy.current = value;
                break;
            case PHY_BASE:
                actor.phy.base = value;
                break;
            case COO_CUR:
                actor.coo.current = value;
                break;
            case COO_BASE:
                actor.coo.base = value;
                break;
            case REAS_CUR:
                actor.rea.current = value;
                break;
            case REAS_BASE:
                actor.rea.base = value;
                break;
            case WILL_CUR:
                actor.wil.current = value;
                break;
            case WILL_BASE:
                actor.wil.base = value;
                break;
            case INST_CUR:
                actor.ins.current = value;
                break;
            case INST_BASE:
                actor.ins.base = value;
                break;
            case VIT_CUR:
                actor.vit.current = value;
                break;
            case VIT_BASE:
                actor.vit.base = value;
                break;
            case HUMAN_CUR:
                actor.human_nex.current = value;
                break;
            case HUMAN_BASE:
                actor.human_nex.base = value;
                break;
            case ANIMAL_CUR:
                actor.animal_nex.current = value;
                break;
            case ANIMAL_BASE:
                actor.animal_nex.base = value;
                break;
            case VEGETAL_CUR:
                actor.vegetal_nex.current = value;
                break;
            case VEGETAL_BASE:
                actor.vegetal_nex.base = value;
                break;
            case INORG_CUR:
                actor.inorganic_nex.current = value;
                break;
            case INORG_BASE:
                actor.inorganic_nex.base = value;
                break;
            case ARTIF_CUR:
                actor.artificial_nex.current = value;
                break;
            case ARTIF_BASE:
                actor.artificial_nex.base = value;
                break;
            case MAGIC_CUR:
                actor.magic_nex.current = value;
                break;
            case MAGIC_BASE:
                actor.magic_nex.base = value;
                break;
            case MAN_S_CUR:
                actor.manufacturing_skill.current = value;
                break;
            case MAN_S_BASE:
                actor.manufacturing_skill.base = value;
                break;
            case HARV_S_CUR:
                actor.harvesting_skill.current = value;
                break;
            case HARV_S_BASE:
                actor.harvesting_skill.base = value;
                break;
            case ALCH_S_CUR:
                actor.alchemy_skill.current = value;
                break;
            case ALCH_S_BASE:
                actor.alchemy_skill.base = value;
                break;
            case OVRL_S_CUR:
                actor.overall_skill.current = value;
                break;
            case OVRL_S_BASE:
                actor.overall_skill.base = value;
                break;
            case DEF_S_CUR:
                actor.defense_skill.current = value;
                break;
            case DEF_S_BASE:
                actor.defense_skill.base = value;
                break;
            case ATT_S_CUR:
                actor.attack_skill.current = value;
                break;
            case ATT_S_BASE:
                actor.attack_skill.base = value;
                break;
            case MAG_S_CUR:
                actor.magic_skill.current = value;
                break;
            case MAG_S_BASE:
                actor.magic_skill.base = value;
                break;
            case POT_S_CUR:
                actor.potion_skill.current = value;
                break;
            case POT_S_BASE:
                actor.potion_skill.base = value;
                break;
            case CARRY_WGHT_CUR:
                actor.capacity.current = value;
                break;
            case CARRY_WGHT_BASE:
                actor.capacity.base = value;
                break;
            case MAT_POINT_CUR:
                actor.materialPoints.current = value;
                break;
            case MAT_POINT_BASE:
                actor.materialPoints.base = value;
                break;
            case ETH_POINT_CUR:
                actor.etherealPoints.current = value;
                break;
            case ETH_POINT_BASE:
                actor.etherealPoints.base = value;
                break;
            case FOOD_LEV:
                actor.food.current = value;
                break;
            case RESEARCHING:
                actor.researching = value;
                break;
            case MAG_RES:
                break;
            case MAN_EXP:
                actor.statistics.manufacturing_exp.current = value;
                break;
            case MAN_EXP_NEXT:
                actor.statistics.manufacturing_exp.base = value;
                break;
            case HARV_EXP:
                actor.statistics.harvesting_exp.current = value;
                break;
            case HARV_EXP_NEXT:
                actor.statistics.harvesting_exp.base = value;
                break;
            case ALCH_EXP:
                actor.statistics.alchemy_exp.current = value;
                break;
            case ALCH_EXP_NEXT:
                actor.statistics.alchemy_exp.base = value;
                break;
            case OVRL_EXP:
                actor.statistics.overall_exp.current = value;
                break;
            case OVRL_EXP_NEXT:
                actor.statistics.overall_exp.base = value;
                break;
            case DEF_EXP:
                actor.statistics.defense_exp.current = value;
                break;
            case DEF_EXP_NEXT:
                actor.statistics.defense_exp.base = value;
                break;
            case ATT_EXP:
                actor.statistics.attack_exp.current = value;
                break;
            case ATT_EXP_NEXT:
                actor.statistics.attack_exp.base = value;
                break;
            case MAG_EXP:
                actor.statistics.magic_exp.current = value;
                break;
            case MAG_EXP_NEXT:
                actor.statistics.magic_exp.base = value;
                break;
            case POT_EXP:
                actor.statistics.potion_exp.current = value;
                break;
            case POT_EXP_NEXT:
                actor.statistics.potion_exp.base = value;
                break;
            case RESEARCH_COMPLETED:
                actor.research_completed = value;
                break;
            case RESEARCH_TOTAL:
                actor.research_total = value;
                break;
            case SUM_EXP:
                actor.statistics.summoning_exp.current = value;
                break;
            case SUM_EXP_NEXT:
                actor.statistics.summoning_exp.base = value;
                break;
            case SUM_S_CUR:
                actor.summoning_skill.current = value;
                break;
            case SUM_S_BASE:
                actor.summoning_skill.base = value;
                break;
            case CRA_EXP:
                actor.statistics.crafting_exp.current = value;
                break;
            case CRA_EXP_NEXT:
                actor.statistics.crafting_exp.base = value;
                break;
            case CRA_S_CUR:
                actor.crafting_skill.current = value;
                break;
            case CRA_S_BASE:
                actor.crafting_skill.base = value;
                break;
            case ENG_EXP:
                actor.statistics.engineering_exp.current = value;
                break;
            case ENG_EXP_NEXT:
                actor.statistics.engineering_exp.base = value;
                break;
            case ENG_S_CUR:
                actor.engineering_skill.current = value;
                break;
            case ENG_S_BASE:
                actor.engineering_skill.base = value;
                break;
            case RANG_EXP:
                actor.statistics.ranging_exp.current = value;
                break;
            case RANG_EXP_NEXT:
                actor.statistics.ranging_exp.base = value;
                break;
            case RANG_S_CUR:
                actor.ranging_skill.current = value;
                break;
            case RANG_S_BASE:
                actor.ranging_skill.base = value;
                break;
            case TAIL_EXP:
                actor.statistics.tailoring_exp.current = value;
                break;
            case TAIL_EXP_NEXT:
                actor.statistics.tailoring_exp.base = value;
                break;
            case TAIL_S_CUR:
                actor.tailoring_skill.current = value;
                break;
            case TAIL_S_BASE:
                actor.tailoring_skill.base = value;
                break;
            case ACTION_POINTS_CUR:
                actor.action_points.current = value;
                break;
            case ACTION_POINTS_BASE:
                actor.action_points.base = value;
                break;
        }
    }

    public static int unsigned(short stat) {
        return stat & 0xffff;
    }


    public static int nex_int(short value, short value2) {
        // This is for byte converting two piece information coming in the initial
        // here your stats message. Since it is converted to a short buffer, some information
        // like overall experience (4 byte integers), comes as two indices of the short buffer.
        return (value2 & 0xFFFF) << 16 | (value & 0xFFFF);
    }

}