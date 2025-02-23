package info.wylan.gena.component;

import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.shared.Tooltip;
import com.vaadin.flow.router.HighlightCondition;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class GenaNavItem extends ListItem {


    public GenaNavItem(MaterialSymbol symbol, String text, Class<? extends Component> navigationTarget) {
        Span span = new Span(text);
        span.addClassNames(Accessibility.SCREEN_READER_ONLY);

        RouterLink link = new RouterLink(navigationTarget);
        link.addClassNames(AlignItems.CENTER, BorderRadius.SMALL, Display.FLEX, JustifyContent.CENTER, Height.MEDIUM,
                Width.MEDIUM);
        link.add(symbol.create(), span);
        link.setHighlightCondition(createHighLightCondition(navigationTarget));

        Tooltip tooltip = Tooltip.forComponent(link);
        tooltip.setPosition(Tooltip.TooltipPosition.END);
        tooltip.setText(text);

        add(link);
    }

    private HighlightCondition<RouterLink> createHighLightCondition(Class<? extends Component> navigationTarget) {
        return (link, afterNavigationEvent) -> afterNavigationEvent.getActiveChain().stream()
                .anyMatch(element -> element.getClass() == navigationTarget);
    }

}
