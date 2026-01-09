task:
	@javac ./lib/Hello.java
	@cd ./lib/; java Hello
	@rm ./lib/*.class
