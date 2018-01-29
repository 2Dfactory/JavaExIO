package test.pattern.decorator;

public class Gateau extends Patisserie {

	@Override
	public String preparer() {
		return "Je suis un gateau et je suis constitué des éléments suivants. \n";
	}

}
