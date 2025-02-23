package info.wylan.gena.component;

import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.UnorderedList;
import info.wylan.gena.theme.NavTheme;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class GenaNav extends Nav {

    private final UnorderedList list;

    public GenaNav(GenaNavItem... items) {
        addClassNames(NavTheme.RAIL);

        list = new UnorderedList(items);
        list.addClassNames(Display.FLEX, FlexDirection.COLUMN, Gap.XSMALL, ListStyleType.NONE, Margin.NONE,
                Padding.NONE);
        add(list);
    }

    public void addNavItem(GenaNavItem item) {
        list.add(item);
    }
}
