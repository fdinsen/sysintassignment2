namespace EmailListenerService.Model
{   
    public class ComplaintDTO
    {
        public VariablesDTO variables;

        public ComplaintDTO(string complaint, string email)
        {
            variables = new VariablesDTO(complaint, email);
        }
    }

    public class VariablesDTO
    {
        public VariableDTO complaint;
        public VariableDTO email;

        public VariablesDTO(string complaint, string email)
        {
            this.complaint = new VariableDTO(complaint, "String");
            this.email = new VariableDTO(email, "String");
        }
    }

    public class VariableDTO
    {
        public string value;
        public string type;

        public VariableDTO(string value, string type)
        {
            this.value = value;
            this.type = type;
        }
    }
}
