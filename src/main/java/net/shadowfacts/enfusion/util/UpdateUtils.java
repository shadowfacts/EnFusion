package net.shadowfacts.enfusion.util;

import net.shadowfacts.enfusion.EnFusion;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author shadowfacts
 */
public class UpdateUtils {

	public static void tryMoveLegacyConfig(File configFolder) {
		Path oldPath = FileSystems.getDefault().getPath(configFolder.getPath(), "enfusion.cfg");
		if (Files.exists(oldPath)) {
			try {
				Path newPath = FileSystems.getDefault().getPath(configFolder.getPath(), "shadow", "EnFusion.cfg");
				Files.move(oldPath, newPath);
			} catch (IOException e) {
				EnFusion.log.error("There was a problem trying to move the old config file to the new location.");
				e.printStackTrace();
			}
		}
	}

}
