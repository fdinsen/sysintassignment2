using MailKit;

namespace EmailListenerService.Model
{
    public class EmailEventArgs : EventArgs
    {
        private readonly IMessageSummary _message;
        public IMessageSummary Message { get { return Message; } }

        public EmailEventArgs(IMessageSummary message)
        {
            this._message = message;
        }

        
    }
}
