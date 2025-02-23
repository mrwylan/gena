package info.wylan.gena.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.Height;
import info.wylan.gena.component.GenaSideBar;

@Route("")
public class HomeView extends VerticalLayout {

    public HomeView() {
        addClassNames(Display.FLEX, Height.FULL);

        add(new GenaSideBar());
    }
}
