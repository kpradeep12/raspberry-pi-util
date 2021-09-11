package net.thetechstack.raspberrypiutil;

import io.javalin.Javalin;
import net.thetechstack.raspberrypiutil.utils.Machine;

public class App 
{
    private static String context = "/pi";
    public static void main( String[] args )
    {
        Javalin app = Javalin.create().start(7000);
        app.get(context + "/hello", ctx -> ctx.result("Hello World"));
        app.get(context + "/shutdown", ctx -> {
           Machine.shutdown();
        });
        app.get(context + "/ip", ctx -> {
            ctx.result(Machine.ipAddress());
        });
        app.get(context + "/reboot", ctx -> {
            Machine.reboot();
        });
        app.get(context + "/help", ctx -> {
            StringBuilder output = new StringBuilder();
            output.append("<ul>");
            output.append("<li>/hello > returns 'Hello World'");
            output.append("<li>/shutdown > Shutdown PI");
            output.append("<li>/reboot > Reboot PI");
            output.append("<li>/ip > returns IP address");
            output.append("</ul>");
            ctx.html(output.toString());
        });
    }
}
