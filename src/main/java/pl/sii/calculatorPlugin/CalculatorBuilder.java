package pl.sii.calculatorPlugin;


import java.io.IOException;
import javax.annotation.Nonnull;

import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.AbstractProject;
import hudson.model.Descriptor;
import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;
import jenkins.tasks.SimpleBuildStep;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.StaplerRequest;

public class CalculatorBuilder extends Builder implements SimpleBuildStep {

    @Override
    public void perform(@Nonnull Run<?, ?> run, @Nonnull FilePath filePath, @Nonnull Launcher launcher, @Nonnull TaskListener taskListener) throws InterruptedException, IOException {
        taskListener.getLogger().println("Calculation results:");
    }

    @Override
    public DescriptorImpl getDescriptor() {
        return (DescriptorImpl) super.getDescriptor();
    }

    @Extension
    public static final class DescriptorImpl extends BuildStepDescriptor<Builder> {
        private NumericalSystem numericalSystem = NumericalSystem.HEX;

        public DescriptorImpl() {
            load();
        }

        @Override
        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            return true;
        }

        @Nonnull
        @Override
        public String getDisplayName() {
            return "Calculate";
        }

        @Override
        public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
            numericalSystem = NumericalSystem.valueOf((String) json.get("numericalSystem"));
            save();
            return super.configure(req, json);
        }

        public NumericalSystem getNumericalSystem() {
            return numericalSystem;
        }
    }
}
