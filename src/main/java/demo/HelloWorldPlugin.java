package demo;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

@Plugin(id = "helloworldplugin", name = "HelloWorld Plugin", version = "1.0")
public class HelloWorldPlugin {
    
    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        
        CommandSpec myCommandSpec = CommandSpec.builder()
            .description(Text.of("Hello World Command"))
            .permission("myplugin.command.helloworld")
            .executor(new HelloWorldCommand())
            .build();

        Sponge.getCommandManager().register(this, myCommandSpec, "helloworld", "hello");
    }

}