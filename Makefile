task:
	@javac ./lib/Hello.java ./lib/Greeter.java
	@cd ./lib/; java Hello
	@rm ./lib/*.class
