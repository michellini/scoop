package com.example.scoop.basics.ui.layoutsample.screen;

import com.example.scoop.basics.R;
import com.example.scoop.basics.ui.layoutsample.module.LayoutModule;
import com.lyft.scoop.Layout;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerModule;

@DaggerModule(values = LayoutModule.class)
@Layout(R.layout.layout_sample)
public class LayoutScreen extends Screen {

    final String param;

    public LayoutScreen(final String param) {
        this.param = param;
    }

    public String getParam(){
        return this.param;
    }
}
