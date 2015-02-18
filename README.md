# EnFusion
EnFusion (ENergetic InFUSION) is a standalone mod (using the RF energy system) primarily about the technological expansion of Minecraft.

Download the latest alpha build [here](https://drone.io/github.com/shadowfacts/EnFusion/files).

## Contributing
### Prerequisites
- JDK (minimum Java 7)
- Git

====

- To download the EnFusion source code navigate to a directory to keep EnFusion inside of, e.g. C:\Users\shadowdfacts\Documents\MinecraftMods.
- Run the command: `git clone https://github.com/shadowfacts/EnFusion.git` to clone the repository.
- Once Git has finished open the EnFusion folder in a new Command Prompt window.
- Next run `git submodule init` to retrieve [ShadowCore](https://github.com/shadowfacts/shadowcore).
- Run `gradlew setupDecompWorkspace idea` to download the dependencies and setup the workspace. **Note:** If you are using Eclipse and not IDEA just replace `idea` with `eclipse`.
- Make any changes you wish to make and test them in the IDE of your choice.
- Lastly, to compile the source code into a .jar file just run the command `gradlew build` and the EnFusion jar will be located in the build/libs directory.



## Credits
- [Shadowfacts](https://github.com/shadowfacts): Lead Developer
- [Lapiman](https://github.com/lapiman): Miscellaneous Textures
- [Mazdallier](https://github.com/mazdallier): Localization
