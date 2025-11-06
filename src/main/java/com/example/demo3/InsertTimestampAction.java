package com.example.demo3;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.project.Project;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InsertTimestampAction extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        Project project = e.getProject();
        if (editor == null || project == null) {
            return;
        }

        Document document = editor.getDocument();
        Caret caret = editor.getCaretModel().getCurrentCaret();
        String timestamp = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        WriteCommandAction.runWriteCommandAction(project, () ->
                document.insertString(caret.getOffset(), timestamp)
        );
    }
}
