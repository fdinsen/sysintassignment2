using EmailListenerService.Model;
using System.Net.Http.Headers;
using Newtonsoft.Json;

namespace EmailListenerService.Services
{
    public class CreateCamundaTaskService
    {
        private const string _url = "http://localhost:8080/engine-rest/process-definition/key/handle-complaint/start";
        static readonly HttpClient client = new();
        public static void CreateCamundaTask(String email, String emlcontent) {
            Console.WriteLine("Ive been called.");
            

            try {
                //string jsonInput = "{\"variables\": {\"complaint\": {\"value\": \"" + emlcontent+"\", \"type\": \"String\"}, \"email\": {\"value\": \""+email+"\", \"type\": \"String\"}}, \"businessKey\": \".netemaillistener\"}";

                ComplaintDTO complaint = new ComplaintDTO(emlcontent, email);
                string jsonInput = JsonConvert.SerializeObject(complaint);
                Console.WriteLine(jsonInput);
                HttpContent content = new StringContent(jsonInput, System.Text.Encoding.UTF8, "application/json");
                content.Headers.ContentType = new System.Net.Http.Headers.MediaTypeHeaderValue("application/json");
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
                client.DefaultRequestHeaders.Connection.Add("keep-alive");
                var response = client.PostAsync(_url, content).Result;
                Console.WriteLine(response);
            }
            catch(Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            
        }
}
}
