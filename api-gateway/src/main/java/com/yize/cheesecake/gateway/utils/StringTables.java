/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/10/26
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.gateway.utils;

import lombok.Getter;

public enum StringTables {
    A("A"),
    a("a"),
    B("B"),
    b("b"),
    A1("1"),
    C("C"),
    c("c"),
    D("D"),
    d("d"),
    A2("2"),
    E("E"),
    e("e"),
    F("F"),
    f("f"),
    G("G"),
    A3("3"),
    g("g"),
    H("H"),
    h("h"),
    A4("4"),
    I("I"),
    i("i"),
    J("J"),
    j("j"),
    A5("5"),
    K("K"),
    k("k"),
    L("L"),
    A6("6"),
    l("l"),
    m("m"),
    M("M"),
    A7("7"),
    O("O"),
    o("o"),
    P("P"),
    p("p"),
    Q("Q"),
    q("q"),
    R("R"),
    A8("8"),
    r("r"),
    S("S"),
    s("s"),
    T("T"),
    A9("9"),
    t("t"),
    U("U"),
    u("u"),
    V("V"),
    v("v"),
    A0("0"),
    W("W"),
    w("w"),
    X("X"),
    x("x"),
    Y("Y"),
    y("y"),
    Z("Z"),
    z("z");

    @Getter
    String values;

    StringTables(String value) {
        this.values = value;
    }
}
