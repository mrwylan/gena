package info.wylan.gena.component;

import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import info.wylan.gena.views.HomeView;

public class GenaSideBar extends Div implements HasTheme {

    public GenaSideBar() {
        addClassNames(BoxShadow.MEDIUM, Display.FLEX, FlexDirection.COLUMN,
                Gap.XLARGE, Height.FULL, Padding.SMALL, ZIndex.XSMALL);

        Image logo = new Image("images/gena.svg", "Gena logo");
        logo.addClassNames(Height.MEDIUM, Padding.XSMALL, Width.MEDIUM);

        GenaNav nav = new GenaNav(
          new GenaNavItem(MaterialSymbol.PERSON_ADD, "Person", HomeView.class )
        );

        add(logo, nav);
    }

}
