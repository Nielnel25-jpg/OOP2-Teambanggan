package Engine;

import java.util.ArrayList;
import java.io.PrintStream;

public class QuestLog {
   private ArrayList<String> completedQuests = new ArrayList();

   public QuestLog() {
   }

   public void complete(String var1) {
      if (!this.isCompleted(var1)) {
         this.completedQuests.add(var1);
         PrintStream var10000 = System.out;
         String var10001 = this.format(var1);
         var10000.println("  [Quest Log] ✔ " + var10001);
      }

   }

   public boolean isCompleted(String var1) {
      return this.completedQuests.contains(var1);
   }

   public int getTotalCompleted() {
      return this.completedQuests.size();
   }

   public void printLog() {
      System.out.println("\n╔══════════════════════════════════════════════════════╗");
      System.out.println("║                     QUEST LOG                        ║");
      System.out.println("╠══════════════════════════════════════════════════════╣");
      if (this.completedQuests.isEmpty()) {
         System.out.println("║  No choices recorded yet.                            ║");
      } else {
         for(String var2 : this.completedQuests) {
            System.out.printf("║  ✔ %-50s║%n", this.format(var2));
         }
      }

      System.out.printf("║  Total choices: %-37d║%n", this.completedQuests.size());
      System.out.println("╚══════════════════════════════════════════════════════╝");
   }

   private String format(String var1) {
      return var1.replace("_", " ");
   }
}