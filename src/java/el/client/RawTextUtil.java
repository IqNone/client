package el.client;

import java.util.ArrayList;
import java.util.List;

import el.actor.Actor;
import el.actor.Span;
import el.actor.Text;
import el.utils.ByteUtils;

import static el.client.Colors.COLORS;
import static el.client.Colors.GREY1;
import static el.client.Colors.getColor;
import static el.client.Colors.isColor;

public class RawTextUtil {
    public static void putRawText(Actor actor, byte[] data) {
        int channel = ByteUtils.unsigned(data[3]);
        List<Span> spans = getSpans(data, 4, data.length);

        if(channel >= 5 && channel <=7) {
            // Add channel number
            // TODO change colour based on active channel
            spans.get(0).text = spans.get(0).text.replaceFirst("]", " @" + actor.channels.get(channel-5)+"]");
        }

        actor.texts.add(new Text(channel, spans));
    }

    public static List<Span> getSpans(byte[] data, int start, int end) {
        int color  = COLORS[GREY1];
        int spanStart = start;
        List<Span> spans = new ArrayList<Span>();

        for(int i = start; i < end; ++i) {
            if(isColor(data[i])) {
                if(i > spanStart) {
                    spans.add(new Span(color, new String(data, spanStart, i - spanStart)));
                }
                color = getColor(data[i]);
                spanStart = i + 1;
            }
        }

        spans.add(new Span(color, new String(data, spanStart, end - spanStart)));

        return spans;
    }
}
