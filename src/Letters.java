
public enum Letters {
	
	A(".-"), B("-..."), C("-.-."), D("-.."), E("."), F("..-."),
	G("--."), H("...."), I(".."), J(".---"), K("-.-"), L(".-.."),
	M("--"), N("-."), O("---"), P(".--."), Q("--.-"), R(".-."),
	S("..."), T("-"), U("..-"), V("...-"), W(".--"), X("-..-"), Y("-.--"),
	Z("--.."),
	a(".-"), b("-..."), c("-.-."), d("-.."), e("."), f("..-."),
	g("--."), h("...."), i(".."), j(".---"), k("-.-"), l(".-.."),
	m("--"), n("-."), o("---"), p(".--."), q("--.-"), r(".-."),
	s("..."), t("-"), u("..-"), v("...-"), w(".--"), x("-..-"), y("-.--"),
	z("--..");
	
	private String morseLetter;
	
	private Letters(String morseLetter) {
		this.morseLetter = morseLetter;
	}
	
	public String getMorse() {
		return morseLetter;
	}
	
}