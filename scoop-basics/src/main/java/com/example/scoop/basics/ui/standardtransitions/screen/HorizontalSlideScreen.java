package com.example.scoop.basics.ui.standardtransitions.screen;

import com.example.scoop.basics.ui.standardtransitions.controller.HorizontalSlideController;
import com.example.scoop.basics.ui.standardtransitions.module.HorizontalSlideModule;
import com.lyft.scoop.Controller;
import com.lyft.scoop.EnterTransition;
import com.lyft.scoop.ExitTransition;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerModule;
import com.lyft.scoop.transitions.BackwardSlideTransition;
import com.lyft.scoop.transitions.ForwardSlideTransition;

@Controller(HorizontalSlideController.class)
@DaggerModule(values = HorizontalSlideModule.class)
@EnterTransition(ForwardSlideTransition.class)
@ExitTransition(BackwardSlideTransition.class)
public class HorizontalSlideScreen extends Screen{
}
