package it.jwisniowski.example.springtestwithdockers.application;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    MyAppIT.class,
    MyAppWithService1IT.class,
    MyAppWithService1AndService2ITImpl.class})
public class MyAppITSuite {
}
